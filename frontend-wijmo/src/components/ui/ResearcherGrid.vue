<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>ParticipationRate &nbsp; ></div>
            <div>&nbsp; 참여연구원</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
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
            <wj-flex-grid-filter :filterColumns="['RowHeader','role','residentId','phoneNumber','highestEducation','highestEducationSchool','highestEducationMajor','monthlySalary','physicalAllowanceRate','cashAllowanceRate','duration','department','researcherNumber','projectMasterId',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="role" header="Role" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="residentId" header="ResidentId" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="phoneNumber" header="PhoneNumber" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="highestEducation" header="HighestEducation" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="highestEducationSchool" header="HighestEducationSchool" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="highestEducationMajor" header="HighestEducationMajor" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="monthlySalary" header="MonthlySalary" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="physicalAllowanceRate" header="PhysicalAllowanceRate" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="cashAllowanceRate" header="CashAllowanceRate" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="duration" header="Duration" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="department" header="Department" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="researcherNumber" header="ResearcherNumber" width="2*" :isReadOnly="true" align="center" />
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
                            <div style="color:white; font-size:17px; font-weight:700;">참여연구원 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <Researcher :offline="offline"
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
    name: 'researcherGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'researchers',
    }),
    watch: {
        newValue: {
            deep:true,
            handler:function(){
                if(!this.newValue){
                    this.newValue = {
                        'name': '',
                        'role': '',
                        'residentId': '',
                        'phoneNumber': '',
                        'highestEducation': '',
                        'highestEducationSchool': '',
                        'highestEducationMajor': '',
                        'monthlySalary': {},
                        'physicalAllowanceRate': 0,
                        'cashAllowanceRate': 0,
                        'duration': 0,
                        'department': '',
                        'researcherNumber': '',
                        'projectMasterId': {},
                    }
                }
            }
        }
    },
    methods:{
    }
}
</script>