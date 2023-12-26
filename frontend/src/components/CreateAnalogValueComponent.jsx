import React, { Component } from 'react'
import AnalogValueService from '../services/AnalogValueService';

class CreateAnalogValueComponent extends Component {
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
            AnalogValueService.getAnalogValueById(this.state.id).then( (res) =>{
                let analogValue = res.data;
                this.setState({
                    value: analogValue.value
                });
            });
        }        
    }
    saveOrUpdateAnalogValue = (e) => {
        e.preventDefault();
        let analogValue = {
                analogValueId: this.state.id,
                value: this.state.value
            };
        console.log('analogValue => ' + JSON.stringify(analogValue));

        // step 5
        if(this.state.id === '_add'){
            analogValue.analogValueId=''
            AnalogValueService.createAnalogValue(analogValue).then(res =>{
                this.props.history.push('/analogValues');
            });
        }else{
            AnalogValueService.updateAnalogValue(analogValue).then( res => {
                this.props.history.push('/analogValues');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/analogValues');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AnalogValue</h3>
        }else{
            return <h3 className="text-center">Update AnalogValue</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAnalogValue}>Save</button>
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

export default CreateAnalogValueComponent
