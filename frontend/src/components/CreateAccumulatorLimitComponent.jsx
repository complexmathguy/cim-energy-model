import React, { Component } from 'react'
import AccumulatorLimitService from '../services/AccumulatorLimitService';

class CreateAccumulatorLimitComponent extends Component {
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
            AccumulatorLimitService.getAccumulatorLimitById(this.state.id).then( (res) =>{
                let accumulatorLimit = res.data;
                this.setState({
                    value: accumulatorLimit.value
                });
            });
        }        
    }
    saveOrUpdateAccumulatorLimit = (e) => {
        e.preventDefault();
        let accumulatorLimit = {
                accumulatorLimitId: this.state.id,
                value: this.state.value
            };
        console.log('accumulatorLimit => ' + JSON.stringify(accumulatorLimit));

        // step 5
        if(this.state.id === '_add'){
            accumulatorLimit.accumulatorLimitId=''
            AccumulatorLimitService.createAccumulatorLimit(accumulatorLimit).then(res =>{
                this.props.history.push('/accumulatorLimits');
            });
        }else{
            AccumulatorLimitService.updateAccumulatorLimit(accumulatorLimit).then( res => {
                this.props.history.push('/accumulatorLimits');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/accumulatorLimits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AccumulatorLimit</h3>
        }else{
            return <h3 className="text-center">Update AccumulatorLimit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAccumulatorLimit}>Save</button>
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

export default CreateAccumulatorLimitComponent
