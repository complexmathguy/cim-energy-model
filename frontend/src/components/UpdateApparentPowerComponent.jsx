import React, { Component } from 'react'
import ApparentPowerService from '../services/ApparentPowerService';

class UpdateApparentPowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updateApparentPower = this.updateApparentPower.bind(this);

        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        ApparentPowerService.getApparentPowerById(this.state.id).then( (res) =>{
            let apparentPower = res.data;
            this.setState({
                multiplier: apparentPower.multiplier,
                unit: apparentPower.unit,
                value: apparentPower.value
            });
        });
    }

    updateApparentPower = (e) => {
        e.preventDefault();
        let apparentPower = {
            apparentPowerId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('apparentPower => ' + JSON.stringify(apparentPower));
        console.log('id => ' + JSON.stringify(this.state.id));
        ApparentPowerService.updateApparentPower(apparentPower).then( res => {
            this.props.history.push('/apparentPowers');
        });
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
        this.props.history.push('/apparentPowers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ApparentPower</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateApparentPower}>Save</button>
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

export default UpdateApparentPowerComponent
