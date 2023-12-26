import React, { Component } from 'react'
import StringMeasurementService from '../services/StringMeasurementService';

class CreateStringMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            StringMeasurementService.getStringMeasurementById(this.state.id).then( (res) =>{
                let stringMeasurement = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateStringMeasurement = (e) => {
        e.preventDefault();
        let stringMeasurement = {
                stringMeasurementId: this.state.id,
            };
        console.log('stringMeasurement => ' + JSON.stringify(stringMeasurement));

        // step 5
        if(this.state.id === '_add'){
            stringMeasurement.stringMeasurementId=''
            StringMeasurementService.createStringMeasurement(stringMeasurement).then(res =>{
                this.props.history.push('/stringMeasurements');
            });
        }else{
            StringMeasurementService.updateStringMeasurement(stringMeasurement).then( res => {
                this.props.history.push('/stringMeasurements');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/stringMeasurements');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add StringMeasurement</h3>
        }else{
            return <h3 className="text-center">Update StringMeasurement</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateStringMeasurement}>Save</button>
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

export default CreateStringMeasurementComponent
