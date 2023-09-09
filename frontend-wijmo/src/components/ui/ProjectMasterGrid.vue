<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>과제등록 &nbsp; ></div>
            <div>&nbsp; 과제 마스터</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="updateProjectDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                <v-icon small>mdi-minus-circle-outline</v-icon>프로젝트 수정
            </v-btn>
            <v-dialog v-model="updateProjectDialog" width="500">
                <UpdateProjectCommand
                    @closeDialog="updateProjectDialog = false"
                    @updateProject="updateProject"
                ></UpdateProjectCommand>
            </v-dialog>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>


        <!-- the grid -->
        <wj-flex-grid
            ref="flexGrid"
            :key="value.length"
            :autoGenerateColumns="false"
            :allowAddNew="false"
            :allowDelete="true"
            :allowPinning="'SingleColumn'"
            :newRowAtTop="false"
            :showMarquee="true"
            :selectionMode="'MultiRange'"
            :validateEdits="false"
            :itemsSource="value"
            :initialized="flexInitialized"
            :selectionChanged="onSelectionChanged"
            style="margin-top:10px; max-height:65vh;"
            class="wj-felx-grid"
        >
            <wj-flex-grid-filter :filterColumns="['RowHeader','noticeProjectName','projectManager','projectName','rfpName','researchManager','cashBurden','materialBurden','totalProjectCost','currentYearProjectCost','totalProjectDuration','currentYearDuration','organName','organBusinessNumber','organDirector','receiptDate','selectionNotification','accountAllocation','projectPlanFile','participationType',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="noticeProjectName" header="공고 사업명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="projectManager" header="사업 담당자" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="projectName" header="과제명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="rfpName" header="RFP명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="researchManager" header="연구 책임자" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="cashBurden" header="현금 부담 여부" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="materialBurden" header="현물 부담 여부" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="totalProjectCost" header="총 사업 비용" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="currentYearProjectCost" header="당해년도 사업 비용" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="totalProjectDuration" header="총 기간(개월)" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="currentYearDuration" header="당해년도 기간" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="organName" header="주관 기관명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="organBusinessNumber" header="주관 기관 사업자 번호" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="organDirector" header="주관 기관 총 책임자" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="receiptDate" header="접수일" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="selectionNotification" header="선정 통보 완료 여부" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="accountAllocation" header="계정 부여 여부" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="participationType" header="ParticipationType" width="2*" :isReadOnly="true" align="center" />
        </wj-flex-grid>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <template>
                    <v-card>
                        <v-toolbar
                            color="primary"
                            class="elevation-0"
                            height="50px"
                        >
                            <div style="color:white; font-size:17px; font-weight:700;">과제 마스터 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <ProjectMaster :offline="offline"
                                :isNew="!itemToEdit"
                                :editMode="true"
                                v-model="newValue"
                                @add="append"
                                @edit="edit"
                            />
                        </v-card-text>
                    </v-card>
                </template>
            </v-dialog>
        </v-col>
        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                    width="332.5"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                >
                    <v-btn
                        style="position:absolute; top:2%; right:2%"
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
import BaseGrid from '../base-ui/BaseGrid'

export default {
    name: 'projectMasterGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'projectMasters',
        updateProjectDialog: false,
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
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
                        'receiptDate': '2023-09-09',
                        'selectionNotification': false,
                        'accountAllocation': false,
                        'projectPlanFile': {},
                        'participationType': {},
                    }
                }
            }
        }
    },
    methods:{
        updateProject(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "updateProject", params)
                this.$EventBus.$emit('show-success','UpdateProject 성공적으로 처리되었습니다.')
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
        },
    }
}
</script>