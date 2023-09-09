<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>예산 &nbsp; ></div>
            <div>&nbsp; 예산</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="updateBudgetDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-minus-circle-outline</v-icon>예산 업데이트
            </v-btn>
            <v-dialog v-model="updateBudgetDialog" width="500">
                <UpdateBudgetCommand
                    @closeDialog="updateBudgetDialog = false"
                    @updateBudget="updateBudget"
                ></UpdateBudgetCommand>
            </v-dialog>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
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
            <wj-flex-grid-filter :filterColumns="['RowHeader','studentResearchCost','privateRatio','privateCashRatio','laborCost','internalLaborCost','externalLaborCost','studentResearchCost','materialCost','researchFacilityCost','activityCost','indirectCost','projectMasterId',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="studentResearchCost" header="정부지원금" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <Money v-model="cell.item.studentResearchCost" :editMode="editMode"></Money>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="privateRatio" header="민간부담율" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="privateCashRatio" header="민간현금부담율" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="laborCost" header="인건비" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <Money v-model="cell.item.laborCost" :editMode="editMode"></Money>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="internalLaborCost" header="내부 인건비" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <Money v-model="cell.item.internalLaborCost" :editMode="editMode"></Money>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="externalLaborCost" header="외부 인건비" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <Money v-model="cell.item.externalLaborCost" :editMode="editMode"></Money>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="studentResearchCost" header="학생 연구비" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <Money v-model="cell.item.studentResearchCost" :editMode="editMode"></Money>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="materialCost" header="재료비" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="researchFacilityCost" header="연구시설장비비" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="activityCost" header="활동비" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="indirectCost" header="간접비" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="projectMasterId" header="과제 마스터" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ProjectMasterId v-model="cell.item.projectMasterId" :editMode="editMode"></ProjectMasterId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
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
                            <div style="color:white; font-size:17px; font-weight:700;">예산 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <Budget :offline="offline"
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
    name: 'budgetGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'budgets',
        updateBudgetDialog: false,
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'taskManagementNumber': '',
                        'studentResearchCost': {},
                        'privateRatio': 0,
                        'privateCashRatio': 0,
                        'laborCost': {},
                        'internalLaborCost': {},
                        'externalLaborCost': {},
                        'studentResearchCost': {},
                        'materialCost': {},
                        'researchFacilityCost': {},
                        'activityCost': {},
                        'indirectCost': {},
                        'projectMasterId': {},
                    }
                }
            }
        }
    },
    methods:{
        updateBudget(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "updateBudget", params)
                this.$EventBus.$emit('show-success','UpdateBudget 성공적으로 처리되었습니다.')
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
        },
    }
}
</script>