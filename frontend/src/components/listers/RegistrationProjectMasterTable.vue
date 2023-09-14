<template>
    <div>
        <v-data-table
                :headers="headers"
                :items="values"
                :items-per-page="5"
                class="elevation-1"
        ></v-data-table>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-fab-transition>
                            <v-btn
                                    color="primary"
                                    fab
                                    dark
                                    large
                                    style="position:absolute; bottom: 5%; right: 2%; z-index:99"
                                    @click="openDialog=true;"
                            >
                                <v-icon v-bind="attrs" v-on="on">mdi-plus</v-icon>
                            </v-btn>
                        </v-fab-transition>
                    </template>

                    <RegistrationProjectMaster :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
                
                    <v-btn
                            style="postition:absolute; top:2%; right:2%"
                            @click="closeDialog()"
                            depressed 
                            icon 
                            absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
    const axios = require('axios').default;
    import RegistrationProjectMaster from './../RegistrationProjectMaster.vue';

    export default {
        name: 'RegistrationProjectMasterManager',
        components: {
            RegistrationProjectMaster,
        },
        props: {
            offline: Boolean,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            values: [],
            headers: 
                [
                    { text: "projectId", value: "projectId" },
                    { text: "noticeProjectName", value: "noticeProjectName" },
                    { text: "projectManager", value: "projectManager" },
                    { text: "projectName", value: "projectName" },
                    { text: "rfpName", value: "rfpName" },
                    { text: "researchManager", value: "researchManager" },
                    { text: "cashBurden", value: "cashBurden" },
                    { text: "materialBurden", value: "materialBurden" },
                    { text: "totalProjectCost", value: "totalProjectCost" },
                    { text: "currentYearProjectCost", value: "currentYearProjectCost" },
                    { text: "totalProjectDuration", value: "totalProjectDuration" },
                    { text: "currentYearDuration", value: "currentYearDuration" },
                    { text: "organName", value: "organName" },
                    { text: "organBusinessNumber", value: "organBusinessNumber" },
                    { text: "organDirector", value: "organDirector" },
                    { text: "receiptDate", value: "receiptDate" },
                    { text: "selectionNotification", value: "selectionNotification" },
                    { text: "accountAllocation", value: "accountAllocation" },
                    { text: "projectPlanFile", value: "projectPlanFile" },
                    { text: "participationType", value: "participationType" },
                ],
            projectMaster : [],
            newValue: {},
            tick : true,
            openDialog : false,
        }),
        async created() {
            if(this.offline){
                if(!this.values) this.values = [];
                return;
            }

            var temp = await axios.get(axios.fixUrl('/projectmasters'))
            temp.data._embedded.projectmasters.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])
            this.values = temp.data._embedded.projectmasters;

            this.newValue = {
                'projectId': '',
                'noticeProjectName': '',
                'projectManager': '',
                'projectName': '',
                'rfpName': '',
                'researchManager': '',
                'cashBurden': false,
                'materialBurden': false,
                'totalProjectCost': 0,
                'currentYearProjectCost': 0,
                'totalProjectDuration': 0,
                'currentYearDuration': '',
                'organName': '',
                'organBusinessNumber': '',
                'organDirector': '',
                'receiptDate': '2023-09-14',
                'selectionNotification': false,
                'accountAllocation': false,
                'projectPlanFile': {},
                'participationType': '',
            }
        },
        methods: {
            closeDialog(){
                this.openDialog = false
            },
            append(value){
                this.tick = false
                this.newValue = {}
                this.values.push(value)
                
                this.$emit('input', this.values);

                this.$nextTick(function(){
                    this.tick=true
                })
            },
        }
    }
</script>

