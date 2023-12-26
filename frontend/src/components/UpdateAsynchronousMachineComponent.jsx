import React, { Component } from 'react'
import AsynchronousMachineService from '../services/AsynchronousMachineService';

class UpdateAsynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
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
        this.updateAsynchronousMachine = this.updateAsynchronousMachine.bind(this);

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

    componentDidMount(){
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

    updateAsynchronousMachine = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineService.updateAsynchronousMachine(asynchronousMachine).then( res => {
            this.props.history.push('/asynchronousMachines');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachine</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> converterFedDrive: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efficiency: </label>
                                            #formFields( $attribute, 'update')
                                            <label> iaIrRatio: </label>
                                            #formFields( $attribute, 'update')
                                            <label> nominalFrequency: </label>
                                            #formFields( $attribute, 'update')
                                            <label> nominalSpeed: </label>
                                            #formFields( $attribute, 'update')
                                            <label> polePairNumber: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratedMechanicalPower: </label>
                                            #formFields( $attribute, 'update')
                                            <label> reversible: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rxLockedRotorRatio: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachine}>Save</button>
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

export default UpdateAsynchronousMachineComponent
