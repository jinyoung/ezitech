<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>집행 &nbsp; ></div>
            <div>&nbsp; 결의</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="updateExpenseResolutionDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-minus-circle-outline</v-icon>결의 수정
            </v-btn>
            <v-dialog v-model="updateExpenseResolutionDialog" width="500">
                <UpdateExpenseResolutionCommand
                    @closeDialog="updateExpenseResolutionDialog = false"
                    @updateExpenseResolution="updateExpenseResolution"
                ></UpdateExpenseResolutionCommand>
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
            <wj-flex-grid-filter :filterColumns="['RowHeader','directOrIndirectExpense','item','resolutionName','totalAmount','vendorName','bankName','bankAccountNumber','accountOwner','resolutionContent','attachments','approvalStatus','approvalLine',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="directOrIndirectExpense" header="비목" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="item" header="세목" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="resolutionName" header="결의명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="totalAmount" header="결의공급가액" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="vendorName" header="지급처명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="bankName" header="은행명" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="bankAccountNumber" header="은행계좌번호" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="accountOwner" header="예금주" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="resolutionContent" header="결의내용" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="attachments" header="붙임파일" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="approvalStatus" header="결재상태" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="approvalLine" header="결재선" width="2*" :isReadOnly="true" align="center" />
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
                            <div style="color:white; font-size:17px; font-weight:700;">결의 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <ExpenseResolution :offline="offline"
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
    name: 'expenseResolutionGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'expenseResolutions',
        updateExpenseResolutionDialog: false,
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'resolutionNumber': '',
                        'directOrIndirectExpense': '',
                        'item': '',
                        'resolutionName': '',
                        'totalAmount': {},
                        'vendorName': '',
                        'bankName': '',
                        'bankAccountNumber': '',
                        'accountOwner': '',
                        'resolutionContent': '',
                        'attachments': [],
                        'approvalStatus': '',
                        'approvalLine': '',
                    }
                }
            }
        }
    },
    methods:{
        updateExpenseResolution(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "updateExpenseResolution", params)
                this.$EventBus.$emit('show-success','UpdateExpenseResolution 성공적으로 처리되었습니다.')
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
        },
    }
}
</script>