<template>
    <v-card outlined>
        <v-card-title>
            ProjectMaster # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="ProjectId" v-model="item.projectId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="NoticeProjectName" v-model="item.noticeProjectName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ProjectManager" v-model="item.projectManager" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ProjectName" v-model="item.projectName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RfpName" v-model="item.rfpName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ResearchManager" v-model="item.researchManager" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="CashBurden" v-model="item.cashBurden" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="MaterialBurden" v-model="item.materialBurden" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="TotalProjectCost" v-model="item.totalProjectCost" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CurrentYearProjectCost" v-model="item.currentYearProjectCost" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="TotalProjectDuration" v-model="item.totalProjectDuration" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CurrentYearDuration" v-model="item.currentYearDuration" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OrganName" v-model="item.organName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OrganBusinessNumber" v-model="item.organBusinessNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OrganDirector" v-model="item.organDirector" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ReceiptDate" v-model="item.receiptDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="SelectionNotification" v-model="item.selectionNotification" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="AccountAllocation" v-model="item.accountAllocation" :editMode="editMode" @change="change" />
            </div>
            <File offline label="ProjectPlanFile" v-model="item.projectPlanFile" :editMode="false" :key="false" @change="change" />
            <ParticipationType offline label="ParticipationType" v-model="item.participationType" :editMode="false" :key="false" @change="change" />
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
        name: 'RegistrationProjectMasterDetail',
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
            var temp = await axios.get(axios.fixUrl('/projectMasters/' + params.id))
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
