<template>
    <v-card outlined>
        <v-card-title>
            Budget # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="TaskManagementNumber" v-model="item.taskManagementNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PrivateRatio" v-model="item.privateRatio" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PrivateCashRatio" v-model="item.privateCashRatio" :editMode="editMode" @change="change" />
            </div>
            <Money offline label="LaborCost" v-model="item.laborCost" :editMode="false" @change="change" />
            <Money offline label="InternalLaborCost" v-model="item.internalLaborCost" :editMode="false" @change="change" />
            <Money offline label="ExternalLaborCost" v-model="item.externalLaborCost" :editMode="false" @change="change" />
            <MaterialCost offline label="MaterialCost" v-model="item.materialCost" :editMode="false" :key="false" @change="change" />
            <ResearchFacilityCost offline label="ResearchFacilityCost" v-model="item.researchFacilityCost" :editMode="false" :key="false" @change="change" />
            <ActivityCost offline label="ActivityCost" v-model="item.activityCost" :editMode="false" :key="false" @change="change" />
            <IndirectCost offline label="IndirectCost" v-model="item.indirectCost" :editMode="false" :key="false" @change="change" />
            <ProjectMasterId offline label="ProjectMasterId" v-model="item.projectMasterId" :editMode="false" :key="false" @change="change" />
        </v-card-text>

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'BudgetBudgetDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/budgets/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
