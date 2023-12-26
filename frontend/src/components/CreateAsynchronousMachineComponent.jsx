import React, { Component } from 'react'
import AsynchronousMachineService from '../services/AsynchronousMachineService';

class CreateAsynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                converterFedDrive: '',
                efficiency: '',
                iaIrRatio: '',
                nominalFrequency: '',
                nominalSpeed: '',
                polePairNumber: '',
                ratedMechanicalPower: '',
                reversible: '',
                rxLockedRotorRatio: ''
        }
        this.changeconverterFedDriveHandler = this.changeconverterFedDriveHandler.bind(this);
        this.changeefficiencyHandler = this.changeefficiencyHandler.bind(this);
        this.changeiaIrRatioHandler = this.changeiaIrRatioHandler.bind(this);
        this.changenominalFrequencyHandler = this.changenominalFrequencyHandler.bind(this);
        this.changenominalSpeedHandler = this.changenominalSpeedHandler.bind(this);
        this.changepolePairNumberHandler = this.changepolePairNumberHandler.bind(this);
        this.changeratedMechanicalPowerHandler = this.changeratedMechanicalPowerHandler.bind(this);
        this.changereversibleHandler = this.changereversibleHandler.bind(this);
        this.changerxLockedRotorRatioHandler = this.changerxLockedRotorRatioHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            AsynchronousMachineService.getAsynchronousMachineById(this.state.id).then( (res) =>{
                let asynchronousMachine = res.data;
                this.setState({
                    converterFedDrive: asynchronousMachine.converterFedDrive,
                    efficiency: asynchronousMachine.efficiency,
                    iaIrRatio: asynchronousMachine.iaIrRatio,
                    nominalFrequency: asynchronousMachine.nominalFrequency,
                    nominalSpeed: asynchronousMachine.nominalSpeed,
                    polePairNumber: asynchronousMachine.polePairNumber,
                    ratedMechanicalPower: asynchronousMachine.ratedMechanicalPower,
                    reversible: asynchronousMachine.reversible,
                    rxLockedRotorRatio: asynchronousMachine.rxLockedRotorRatio
                });
            });
        }        
    }
    saveOrUpdateAsynchronousMachine = (e) => {
        e.preventDefault();
        let asynchronousMachine = {
                asynchronousMachineId: this.state.id,
                converterFedDrive: this.state.converterFedDrive,
                efficiency: this.state.efficiency,
                iaIrRatio: this.state.iaIrRatio,
                nominalFrequency: this.state.nominalFrequency,
                nominalSpeed: this.state.nominalSpeed,
                polePairNumber: this.state.polePairNumber,
                ratedMechanicalPower: this.state.ratedMechanicalPower,
                reversible: this.state.reversible,
                rxLockedRotorRatio: this.state.rxLockedRotorRatio
            };
        console.log('asynchronousMachine => ' + JSON.stringify(asynchronousMachine));

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachine.asynchronousMachineId=''
            AsynchronousMachineService.createAsynchronousMachine(asynchronousMachine).then(res =>{
                this.props.history.push('/asynchronousMachines');
            });
        }else{
            AsynchronousMachineService.updateAsynchronousMachine(asynchronousMachine).then( res => {
                this.props.history.push('/asynchronousMachines');
            });
        }
    }
    
    changeconverterFedDriveHandler= (event) => {
        this.setState({converterFedDrive: event.target.value});
    }
    changeefficiencyHandler= (event) => {
        this.setState({efficiency: event.target.value});
    }
    changeiaIrRatioHandler= (event) => {
        this.setState({iaIrRatio: event.target.value});
    }
    changenominalFrequencyHandler= (event) => {
        this.setState({nominalFrequency: event.target.value});
    }
    changenominalSpeedHandler= (event) => {
        this.setState({nominalSpeed: event.target.value});
    }
    changepolePairNumberHandler= (event) => {
        this.setState({polePairNumber: event.target.value});
    }
    changeratedMechanicalPowerHandler= (event) => {
        this.setState({ratedMechanicalPower: event.target.value});
    }
    changereversibleHandler= (event) => {
        this.setState({reversible: event.target.value});
    }
    changerxLockedRotorRatioHandler= (event) => {
        this.setState({rxLockedRotorRatio: event.target.value});
    }

    cancel(){
        this.props.history.push('/asynchronousMachines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachine</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachine</h3>
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
                                            <label> converterFedDrive: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efficiency: </label>
                                            #formFields( $attribute, 'create')
                                            <label> iaIrRatio: </label>
                                            #formFields( $attribute, 'create')
                                            <label> nominalFrequency: </label>
                                            #formFields( $attribute, 'create')
                                            <label> nominalSpeed: </label>
                                            #formFields( $attribute, 'create')
                                            <label> polePairNumber: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedMechanicalPower: </label>
                                            #formFields( $attribute, 'create')
                                            <label> reversible: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rxLockedRotorRatio: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachine}>Save</button>
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

export default CreateAsynchronousMachineComponent
