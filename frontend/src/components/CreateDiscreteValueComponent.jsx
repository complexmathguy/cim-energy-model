import React, { Component } from 'react'
import DiscreteValueService from '../services/DiscreteValueService';

class CreateDiscreteValueComponent extends Component {
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
            DiscreteValueService.getDiscreteValueById(this.state.id).then( (res) =>{
                let discreteValue = res.data;
                this.setState({
                    value: discreteValue.value
                });
            });
        }        
    }
    saveOrUpdateDiscreteValue = (e) => {
        e.preventDefault();
        let discreteValue = {
                discreteValueId: this.state.id,
                value: this.state.value
            };
        console.log('discreteValue => ' + JSON.stringify(discreteValue));

        // step 5
        if(this.state.id === '_add'){
            discreteValue.discreteValueId=''
            DiscreteValueService.createDiscreteValue(discreteValue).then(res =>{
                this.props.history.push('/discreteValues');
            });
        }else{
            DiscreteValueService.updateDiscreteValue(discreteValue).then( res => {
                this.props.history.push('/discreteValues');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/discreteValues');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiscreteValue</h3>
        }else{
            return <h3 className="text-center">Update DiscreteValue</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiscreteValue}>Save</button>
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

export default CreateDiscreteValueComponent
