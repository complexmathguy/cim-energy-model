import React, { Component } from 'react'
import CapacitancePerLengthService from '../services/CapacitancePerLengthService';

class UpdateCapacitancePerLengthComponent extends Component {
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
        this.updateCapacitancePerLength = this.updateCapacitancePerLength.bind(this);

        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        CapacitancePerLengthService.getCapacitancePerLengthById(this.state.id).then( (res) =>{
            let capacitancePerLength = res.data;
            this.setState({
                denominatorMultiplier: capacitancePerLength.denominatorMultiplier,
                denominatorUnit: capacitancePerLength.denominatorUnit,
                multiplier: capacitancePerLength.multiplier,
                unit: capacitancePerLength.unit,
                value: capacitancePerLength.value
            });
        });
    }

    updateCapacitancePerLength = (e) => {
        e.preventDefault();
        let capacitancePerLength = {
            capacitancePerLengthId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('capacitancePerLength => ' + JSON.stringify(capacitancePerLength));
        console.log('id => ' + JSON.stringify(this.state.id));
        CapacitancePerLengthService.updateCapacitancePerLength(capacitancePerLength).then( res => {
            this.props.history.push('/capacitancePerLengths');
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
        this.props.history.push('/capacitancePerLengths');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update CapacitancePerLength</h3>
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
                                        <button className="btn btn-success" onClick={this.updateCapacitancePerLength}>Save</button>
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

export default UpdateCapacitancePerLengthComponent
