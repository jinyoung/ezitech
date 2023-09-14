<template>
    <div>
    <h1>과제 마스터</h1>
        <v-row>
            <v-card
                class="mx-auto"
                style="height:300px; width:300px; margin-bottom:20px; text-align: center;"
                outlined
            >
                <v-list-item>
                    <v-list-item-avatar 
                        class="mx-auto"
                        size="80"
                        style="margin-top:80px;"
                    ><v-icon color="primary" x-large>mdi-plus</v-icon>
                    </v-list-item-avatar>
                </v-list-item>

                <v-card-actions>
                    <v-btn 
                        v-on="on"
                        class="mx-auto"
                        outlined
                        rounded
                        @click="openDialog=true;"
                        color="primary"
                        style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                    >
                        과제 마스터 등록
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-row>
        <v-list two-line>
            <template>
                <v-list-item v-for="(data, n) in values" :key="n">
                    <v-list-item-avatar color="grey darken-1">
                        <v-img :src="data.photo ? data.photo:'https://cdn.vuetifyjs.com/images/cards/cooking.png'"/>
                    </v-list-item-avatar>

                    <v-list-item-content>
                        <v-list-item-title style="margin-bottom:10px;">
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                        </v-list-item-title>

                        <v-list-item-subtitle style="font-size:25px; font-weight:700;">
                            [ ProjectId :  {{data.projectId }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ NoticeProjectName :  {{data.noticeProjectName }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ProjectManager :  {{data.projectManager }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ProjectName :  {{data.projectName }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ RfpName :  {{data.rfpName }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ResearchManager :  {{data.researchManager }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CashBurden :  {{data.cashBurden }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ MaterialBurden :  {{data.materialBurden }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ TotalProjectCost :  {{data.totalProjectCost }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CurrentYearProjectCost :  {{data.currentYearProjectCost }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ TotalProjectDuration :  {{data.totalProjectDuration }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ CurrentYearDuration :  {{data.currentYearDuration }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OrganName :  {{data.organName }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OrganBusinessNumber :  {{data.organBusinessNumber }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ OrganDirector :  {{data.organDirector }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ReceiptDate :  {{data.receiptDate }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ SelectionNotification :  {{data.selectionNotification }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ AccountAllocation :  {{data.accountAllocation }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ProjectPlanFile :  {{data.projectPlanFile }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            [ ParticipationType :  {{data.participationType }} ] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </v-list-item-subtitle>

                    </v-list-item-content>
                </v-list-item>

                <v-divider v-if="n !== 6" :key="`divider-${n}`" inset></v-divider>
            </template>
        </v-list>

        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                        v-model="openDialog"
                        width="332.5"
                        fullscreen
                        hide-overlay
                        transition="dialog-bottom-transition"
                >

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
            }
        },
    };
</script>


<style>
    .video-card {
        width:300px; 
        margin-left:4.5%; 
        margin-top:50px; 
        margin-bottom:50px;
    }
</style>

