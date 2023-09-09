<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="primary"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="primary-darker-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                TaskManagementNumber :  {{item.taskManagementNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                StudentResearchCost :  {{item.studentResearchCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PrivateRatio :  {{item.privateRatio }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PrivateCashRatio :  {{item.privateCashRatio }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                LaborCost :  {{item.laborCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                InternalLaborCost :  {{item.internalLaborCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ExternalLaborCost :  {{item.externalLaborCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                StudentResearchCost :  {{item.studentResearchCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                MaterialCost :  {{item.materialCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ResearchFacilityCost :  {{item.researchFacilityCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ActivityCost :  {{item.activityCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                IndirectCost :  {{item.indirectCost }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ProjectMasterId :  {{item.projectMasterId }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="primary-darker-1"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'BudgetBudgetPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/budgets'))
            if(temp.data) {
                me.list = temp.data._embedded.budgets;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/budgets/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['taskManagementNumber'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

