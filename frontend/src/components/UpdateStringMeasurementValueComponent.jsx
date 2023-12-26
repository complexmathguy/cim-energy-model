import React, { Component } from 'react'
import StringMeasurementValueService from '../services/StringMeasurementValueService';

class UpdateStringMeasurementValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateStringMeasurementValue = this.updateStringMeasurementValue.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        StringMeasurementValueService.getStringMeasurementValueById(this.state.id).then( (res) =>{
            let stringMeasurementValue = res.data;
            this.setState({
                value: stringMeasurementValue.value
            });
        });
    }

    updateStringMeasurementValue = (e) => {
        e.preventDefault();
        let stringMeasurementValue = {
            stringMeasurementValueId: this.state.id,
            value: this.state.value
        };
        console.log('stringMeasurementValue => ' + JSON.stringify(stringMeasurementValue));
        console.log('id => ' + JSON.stringify(this.state.id));
        StringMeasurementValueService.updateStringMeasurementValue(stringMeasurementValue).then( res => {
            this.props.history.push('/stringMeasurementValues');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/stringMeasurementValues');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update StringMeasurementValue</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStringMeasurementValue}>Save</button>
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

export default UpdateStringMeasurementValueComponent
