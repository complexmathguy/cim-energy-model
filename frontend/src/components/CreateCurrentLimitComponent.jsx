import React, { Component } from 'react'
import CurrentLimitService from '../services/CurrentLimitService';

class CreateCurrentLimitComponent extends Component {
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
            CurrentLimitService.getCurrentLimitById(this.state.id).then( (res) =>{
                let currentLimit = res.data;
                this.setState({
                    value: currentLimit.value
                });
            });
        }        
    }
    saveOrUpdateCurrentLimit = (e) => {
        e.preventDefault();
        let currentLimit = {
                currentLimitId: this.state.id,
                value: this.state.value
            };
        console.log('currentLimit => ' + JSON.stringify(currentLimit));

        // step 5
        if(this.state.id === '_add'){
            currentLimit.currentLimitId=''
            CurrentLimitService.createCurrentLimit(currentLimit).then(res =>{
                this.props.history.push('/currentLimits');
            });
        }else{
            CurrentLimitService.updateCurrentLimit(currentLimit).then( res => {
                this.props.history.push('/currentLimits');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/currentLimits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add CurrentLimit</h3>
        }else{
            return <h3 className="text-center">Update CurrentLimit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCurrentLimit}>Save</button>
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

export default CreateCurrentLimitComponent
