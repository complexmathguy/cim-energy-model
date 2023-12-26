import React, { Component } from 'react'
import StringMeasurementService from '../services/StringMeasurementService';

class UpdateStringMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateStringMeasurement = this.updateStringMeasurement.bind(this);

    }

    componentDidMount(){
        StringMeasurementService.getStringMeasurementById(this.state.id).then( (res) =>{
            let stringMeasurement = res.data;
            this.setState({
            });
        });
    }

    updateStringMeasurement = (e) => {
        e.preventDefault();
        let stringMeasurement = {
            stringMeasurementId: this.state.id,
        };
        console.log('stringMeasurement => ' + JSON.stringify(stringMeasurement));
        console.log('id => ' + JSON.stringify(this.state.id));
        StringMeasurementService.updateStringMeasurement(stringMeasurement).then( res => {
            this.props.history.push('/stringMeasurements');
        });
    }


    cancel(){
        this.props.history.push('/stringMeasurements');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update StringMeasurement</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStringMeasurement}>Save</button>
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

export default UpdateStringMeasurementComponent
