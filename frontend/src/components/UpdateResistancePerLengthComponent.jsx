import React, { Component } from 'react'
import ResistancePerLengthService from '../services/ResistancePerLengthService';

class UpdateResistancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updateResistancePerLength = this.updateResistancePerLength.bind(this);

        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
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

    updateResistancePerLength = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        ResistancePerLengthService.updateResistancePerLength(resistancePerLength).then( res => {
            this.props.history.push('/resistancePerLengths');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ResistancePerLength</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> denominatorMultiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> denominatorUnit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateResistancePerLength}>Save</button>
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

export default UpdateResistancePerLengthComponent
