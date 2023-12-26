import React, { Component } from 'react'
import AngleDegreesService from '../services/AngleDegreesService';

class UpdateAngleDegreesComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updateAngleDegrees = this.updateAngleDegrees.bind(this);

        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        AngleDegreesService.getAngleDegreesById(this.state.id).then( (res) =>{
            let angleDegrees = res.data;
            this.setState({
                multiplier: angleDegrees.multiplier,
                unit: angleDegrees.unit,
                value: angleDegrees.value
            });
        });
    }

    updateAngleDegrees = (e) => {
        e.preventDefault();
        let angleDegrees = {
            angleDegreesId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('angleDegrees => ' + JSON.stringify(angleDegrees));
        console.log('id => ' + JSON.stringify(this.state.id));
        AngleDegreesService.updateAngleDegrees(angleDegrees).then( res => {
            this.props.history.push('/angleDegreess');
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
        this.props.history.push('/angleDegreess');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AngleDegrees</h3>
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
                                        <button className="btn btn-success" onClick={this.updateAngleDegrees}>Save</button>
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

export default UpdateAngleDegreesComponent
