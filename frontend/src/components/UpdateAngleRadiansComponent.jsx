import React, { Component } from 'react'
import AngleRadiansService from '../services/AngleRadiansService';

class UpdateAngleRadiansComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updateAngleRadians = this.updateAngleRadians.bind(this);

        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        AngleRadiansService.getAngleRadiansById(this.state.id).then( (res) =>{
            let angleRadians = res.data;
            this.setState({
                multiplier: angleRadians.multiplier,
                unit: angleRadians.unit,
                value: angleRadians.value
            });
        });
    }

    updateAngleRadians = (e) => {
        e.preventDefault();
        let angleRadians = {
            angleRadiansId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('angleRadians => ' + JSON.stringify(angleRadians));
        console.log('id => ' + JSON.stringify(this.state.id));
        AngleRadiansService.updateAngleRadians(angleRadians).then( res => {
            this.props.history.push('/angleRadianss');
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
        this.props.history.push('/angleRadianss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AngleRadians</h3>
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
                                        <button className="btn btn-success" onClick={this.updateAngleRadians}>Save</button>
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

export default UpdateAngleRadiansComponent
