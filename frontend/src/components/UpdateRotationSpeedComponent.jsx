import React, { Component } from 'react'
import RotationSpeedService from '../services/RotationSpeedService';

class UpdateRotationSpeedComponent extends Component {
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
        this.updateRotationSpeed = this.updateRotationSpeed.bind(this);

        this.changedenominatorMultiplierHandler = this.changedenominatorMultiplierHandler.bind(this);
        this.changedenominatorUnitHandler = this.changedenominatorUnitHandler.bind(this);
        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        RotationSpeedService.getRotationSpeedById(this.state.id).then( (res) =>{
            let rotationSpeed = res.data;
            this.setState({
                denominatorMultiplier: rotationSpeed.denominatorMultiplier,
                denominatorUnit: rotationSpeed.denominatorUnit,
                multiplier: rotationSpeed.multiplier,
                unit: rotationSpeed.unit,
                value: rotationSpeed.value
            });
        });
    }

    updateRotationSpeed = (e) => {
        e.preventDefault();
        let rotationSpeed = {
            rotationSpeedId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('rotationSpeed => ' + JSON.stringify(rotationSpeed));
        console.log('id => ' + JSON.stringify(this.state.id));
        RotationSpeedService.updateRotationSpeed(rotationSpeed).then( res => {
            this.props.history.push('/rotationSpeeds');
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
        this.props.history.push('/rotationSpeeds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RotationSpeed</h3>
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
                                        <button className="btn btn-success" onClick={this.updateRotationSpeed}>Save</button>
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

export default UpdateRotationSpeedComponent
