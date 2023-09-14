<template>
    <v-card outlined>
        <v-card-title>
            InHireCost # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Role" v-model="item.role" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ResidentRegistrationNumber" v-model="item.residentRegistrationNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PhoneNumber" v-model="item.phoneNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FinalEducation" v-model="item.finalEducation" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FinalEducationSchool" v-model="item.finalEducationSchool" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FinalEducationMajor" v-model="item.finalEducationMajor" :editMode="editMode" @change="change" />
            </div>
            <Money offline label="MonthlySalary" v-model="item.monthlySalary" :editMode="false" @change="change" />
            <div>
                <Number label="PhysicalRatio" v-model="item.physicalRatio" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CashRatio" v-model="item.cashRatio" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Duration" v-model="item.duration" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Department" v-model="item.department" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="NationalResearcherNumber" v-model="item.nationalResearcherNumber" :editMode="editMode" @change="change" />
            </div>
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
        name: 'ParticipationRateInHireCostDetail',
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
            var temp = await axios.get(axios.fixUrl('/inHireCosts/' + params.id))
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
