import React, { Component } from 'react'
import ResistancePerLengthService from '../services/ResistancePerLengthService';

class CreateResistancePerLengthComponent extends Component {
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
            ResistancePerLengthService.getResistancePerLengthById(this.state.id).then( (res) =>{
                let resistancePerLength = res.data;
                this.setState({
                    denominatorMultiplier: resistancePerLength.denominatorMultiplier,
                    denominatorUnit: resistancePerLength.denominatorUnit,
                    multiplier: resistancePerLength.multiplier,
                    unit: resistancePerLength.unit,
                    value: resistancePerLength.value
                });
            });
        }        
    }
    saveOrUpdateResistancePerLength = (e) => {
        e.preventDefault();
        let resistancePerLength = {
                resistancePerLengthId: this.state.id,
                denominatorMultiplier: this.state.denominatorMultiplier,
                denominatorUnit: this.state.denominatorUnit,
                multiplier: this.state.multiplier,
                unit: this.state.unit,
                value: this.state.value
            };
        console.log('resistancePerLength => ' + JSON.stringify(resistancePerLength));

        // step 5
        if(this.state.id === '_add'){
            resistancePerLength.resistancePerLengthId=''
            ResistancePerLengthService.createResistancePerLength(resistancePerLength).then(res =>{
                this.props.history.push('/resistancePerLengths');
            });
        }else{
            ResistancePerLengthService.updateResistancePerLength(resistancePerLength).then( res => {
                this.props.history.push('/resistancePerLengths');
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
        this.props.history.push('/resistancePerLengths');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ResistancePerLength</h3>
        }else{
            return <h3 className="text-center">Update ResistancePerLength</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateResistancePerLength}>Save</button>
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

export default CreateResistancePerLengthComponent
