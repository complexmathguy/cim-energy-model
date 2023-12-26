import React, { Component } from 'react'
import AnalogLimitService from '../services/AnalogLimitService';

class CreateAnalogLimitComponent extends Component {
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
            AnalogLimitService.getAnalogLimitById(this.state.id).then( (res) =>{
                let analogLimit = res.data;
                this.setState({
                    value: analogLimit.value
                });
            });
        }        
    }
    saveOrUpdateAnalogLimit = (e) => {
        e.preventDefault();
        let analogLimit = {
                analogLimitId: this.state.id,
                value: this.state.value
            };
        console.log('analogLimit => ' + JSON.stringify(analogLimit));

        // step 5
        if(this.state.id === '_add'){
            analogLimit.analogLimitId=''
            AnalogLimitService.createAnalogLimit(analogLimit).then(res =>{
                this.props.history.push('/analogLimits');
            });
        }else{
            AnalogLimitService.updateAnalogLimit(analogLimit).then( res => {
                this.props.history.push('/analogLimits');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/analogLimits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AnalogLimit</h3>
        }else{
            return <h3 className="text-center">Update AnalogLimit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAnalogLimit}>Save</button>
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

export default CreateAnalogLimitComponent
