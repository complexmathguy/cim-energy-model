import React, { Component } from 'react'
import ActivePowerPerFrequencyService from '../services/ActivePowerPerFrequencyService';

class CreateActivePowerPerFrequencyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: '',
                value: ''
        }
        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ActivePowerPerFrequencyService.getActivePowerPerFrequencyById(this.state.id).then( (res) =>{
                let activePowerPerFrequency = res.data;
                this.setState({
                    denominatorMultiplier: activePowerPerFrequency.denominatorMultiplier,
                    denominatorUnit: activePowerPerFrequency.denominatorUnit,
                    multiplier: activePowerPerFrequency.multiplier,
                    unit: activePowerPerFrequency.unit,
                    value: activePowerPerFrequency.value
                });
            });
        }        
    }
    saveOrUpdateActivePowerPerFrequency = (e) => {
        e.preventDefault();
        let activePowerPerFrequency = {
                activePowerPerFrequencyId: this.state.id,
                denominatorMultiplier: this.state.denominatorMultiplier,
                denominatorUnit: this.state.denominatorUnit,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('activePowerPerFrequency => ' + JSON.stringify(activePowerPerFrequency));

        // step 5
        if(this.state.id === '_add'){
            activePowerPerFrequency.activePowerPerFrequencyId=''
            ActivePowerPerFrequencyService.createActivePowerPerFrequency(activePowerPerFrequency).then(res =>{
                this.props.history.push('/activePowerPerFrequencys');
            });
        }else{
            ActivePowerPerFrequencyService.updateActivePowerPerFrequency(activePowerPerFrequency).then( res => {
                this.props.history.push('/activePowerPerFrequencys');
            });
        }
    }
    
    changedenominatorMultiplierHandler= (event) => {
        this.setState({denominatorMultiplier: event.target.value});
    }
    changedenominatorUnitHandler= (event) => {
        this.setState({denominatorUnit: event.target.value});
    }
    changemultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeunitHandler= (event) => {
        this.setState({unit: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/activePowerPerFrequencys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ActivePowerPerFrequency</h3>
        }else{
            return <h3 className="text-center">Update ActivePowerPerFrequency</h3>
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
                                            <label> denominatorMultiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> denominatorUnit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateActivePowerPerFrequency}>Save</button>
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

export default CreateActivePowerPerFrequencyComponent
