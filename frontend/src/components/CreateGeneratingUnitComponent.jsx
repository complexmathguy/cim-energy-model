import React, { Component } from 'react'
import GeneratingUnitService from '../services/GeneratingUnitService';

class CreateGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                genControlSource: '',
                governorSCD: '',
                initialP: '',
                longPF: '',
                maximumAllowableSpinningReserve: '',
                maxOperatingP: '',
                minOperatingP: '',
                nominalP: '',
                ratedGrossMaxP: '',
                ratedGrossMinP: '',
                ratedNetMaxP: '',
                shortPF: '',
                startupCost: '',
                totalEfficiency: '',
                variableCost: ''
        }
        this.changegenControlSourceHandler = this.changegenControlSourceHandler.bind(this);
        this.changegovernorSCDHandler = this.changegovernorSCDHandler.bind(this);
        this.changeinitialPHandler = this.changeinitialPHandler.bind(this);
        this.changelongPFHandler = this.changelongPFHandler.bind(this);
        this.changemaximumAllowableSpinningReserveHandler = this.changemaximumAllowableSpinningReserveHandler.bind(this);
        this.changemaxOperatingPHandler = this.changemaxOperatingPHandler.bind(this);
        this.changeminOperatingPHandler = this.changeminOperatingPHandler.bind(this);
        this.changenominalPHandler = this.changenominalPHandler.bind(this);
        this.changeratedGrossMaxPHandler = this.changeratedGrossMaxPHandler.bind(this);
        this.changeratedGrossMinPHandler = this.changeratedGrossMinPHandler.bind(this);
        this.changeratedNetMaxPHandler = this.changeratedNetMaxPHandler.bind(this);
        this.changeshortPFHandler = this.changeshortPFHandler.bind(this);
        this.changestartupCostHandler = this.changestartupCostHandler.bind(this);
        this.changetotalEfficiencyHandler = this.changetotalEfficiencyHandler.bind(this);
        this.changevariableCostHandler = this.changevariableCostHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GeneratingUnitService.getGeneratingUnitById(this.state.id).then( (res) =>{
                let generatingUnit = res.data;
                this.setState({
                    genControlSource: generatingUnit.genControlSource,
                    governorSCD: generatingUnit.governorSCD,
                    initialP: generatingUnit.initialP,
                    longPF: generatingUnit.longPF,
                    maximumAllowableSpinningReserve: generatingUnit.maximumAllowableSpinningReserve,
                    maxOperatingP: generatingUnit.maxOperatingP,
                    minOperatingP: generatingUnit.minOperatingP,
                    nominalP: generatingUnit.nominalP,
                    ratedGrossMaxP: generatingUnit.ratedGrossMaxP,
                    ratedGrossMinP: generatingUnit.ratedGrossMinP,
                    ratedNetMaxP: generatingUnit.ratedNetMaxP,
                    shortPF: generatingUnit.shortPF,
                    startupCost: generatingUnit.startupCost,
                    totalEfficiency: generatingUnit.totalEfficiency,
                    variableCost: generatingUnit.variableCost
                });
            });
        }        
    }
    saveOrUpdateGeneratingUnit = (e) => {
        e.preventDefault();
        let generatingUnit = {
                generatingUnitId: this.state.id,
                genControlSource: this.state.genControlSource,
                governorSCD: this.state.governorSCD,
                initialP: this.state.initialP,
                longPF: this.state.longPF,
                maximumAllowableSpinningReserve: this.state.maximumAllowableSpinningReserve,
                maxOperatingP: this.state.maxOperatingP,
                minOperatingP: this.state.minOperatingP,
                nominalP: this.state.nominalP,
                ratedGrossMaxP: this.state.ratedGrossMaxP,
                ratedGrossMinP: this.state.ratedGrossMinP,
                ratedNetMaxP: this.state.ratedNetMaxP,
                shortPF: this.state.shortPF,
                startupCost: this.state.startupCost,
                totalEfficiency: this.state.totalEfficiency,
                variableCost: this.state.variableCost
            };
        console.log('generatingUnit => ' + JSON.stringify(generatingUnit));

        // step 5
        if(this.state.id === '_add'){
            generatingUnit.generatingUnitId=''
            GeneratingUnitService.createGeneratingUnit(generatingUnit).then(res =>{
                this.props.history.push('/generatingUnits');
            });
        }else{
            GeneratingUnitService.updateGeneratingUnit(generatingUnit).then( res => {
                this.props.history.push('/generatingUnits');
            });
        }
    }
    
    changegenControlSourceHandler= (event) => {
        this.setState({genControlSource: event.target.value});
    }
    changegovernorSCDHandler= (event) => {
        this.setState({governorSCD: event.target.value});
    }
    changeinitialPHandler= (event) => {
        this.setState({initialP: event.target.value});
    }
    changelongPFHandler= (event) => {
        this.setState({longPF: event.target.value});
    }
    changemaximumAllowableSpinningReserveHandler= (event) => {
        this.setState({maximumAllowableSpinningReserve: event.target.value});
    }
    changemaxOperatingPHandler= (event) => {
        this.setState({maxOperatingP: event.target.value});
    }
    changeminOperatingPHandler= (event) => {
        this.setState({minOperatingP: event.target.value});
    }
    changenominalPHandler= (event) => {
        this.setState({nominalP: event.target.value});
    }
    changeratedGrossMaxPHandler= (event) => {
        this.setState({ratedGrossMaxP: event.target.value});
    }
    changeratedGrossMinPHandler= (event) => {
        this.setState({ratedGrossMinP: event.target.value});
    }
    changeratedNetMaxPHandler= (event) => {
        this.setState({ratedNetMaxP: event.target.value});
    }
    changeshortPFHandler= (event) => {
        this.setState({shortPF: event.target.value});
    }
    changestartupCostHandler= (event) => {
        this.setState({startupCost: event.target.value});
    }
    changetotalEfficiencyHandler= (event) => {
        this.setState({totalEfficiency: event.target.value});
    }
    changevariableCostHandler= (event) => {
        this.setState({variableCost: event.target.value});
    }

    cancel(){
        this.props.history.push('/generatingUnits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GeneratingUnit</h3>
        }else{
            return <h3 className="text-center">Update GeneratingUnit</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> genControlSource: </label>
                                            #formFields( $attribute, 'create')
                                            <label> governorSCD: </label>
                                            #formFields( $attribute, 'create')
                                            <label> initialP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> longPF: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maximumAllowableSpinningReserve: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxOperatingP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minOperatingP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> nominalP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedGrossMaxP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedGrossMinP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedNetMaxP: </label>
                                            #formFields( $attribute, 'create')
                                            <label> shortPF: </label>
                                            #formFields( $attribute, 'create')
                                            <label> startupCost: </label>
                                            #formFields( $attribute, 'create')
                                            <label> totalEfficiency: </label>
                                            #formFields( $attribute, 'create')
                                            <label> variableCost: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGeneratingUnit}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateGeneratingUnitComponent
