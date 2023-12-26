import React, { Component } from 'react'
import StringMeasurementValueService from '../services/StringMeasurementValueService';

class CreateStringMeasurementValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                value: ''
        }
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            StringMeasurementValueService.getStringMeasurementValueById(this.state.id).then( (res) =>{
                let stringMeasurementValue = res.data;
                this.setState({
                    value: stringMeasurementValue.value
                });
            });
        }        
    }
    saveOrUpdateStringMeasurementValue = (e) => {
        e.preventDefault();
        let stringMeasurementValue = {
                stringMeasurementValueId: this.state.id,
                value: this.state.value
            };
        console.log('stringMeasurementValue => ' + JSON.stringify(stringMeasurementValue));

        // step 5
        if(this.state.id === '_add'){
            stringMeasurementValue.stringMeasurementValueId=''
            StringMeasurementValueService.createStringMeasurementValue(stringMeasurementValue).then(res =>{
                this.props.history.push('/stringMeasurementValues');
            });
        }else{
            StringMeasurementValueService.updateStringMeasurementValue(stringMeasurementValue).then( res => {
                this.props.history.push('/stringMeasurementValues');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/stringMeasurementValues');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add StringMeasurementValue</h3>
        }else{
            return <h3 className="text-center">Update StringMeasurementValue</h3>
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
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateStringMeasurementValue}>Save</button>
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

export default CreateStringMeasurementValueComponent
