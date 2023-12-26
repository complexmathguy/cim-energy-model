import React, { Component } from 'react'
import AccumulatorValueService from '../services/AccumulatorValueService';

class CreateAccumulatorValueComponent extends Component {
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
            AccumulatorValueService.getAccumulatorValueById(this.state.id).then( (res) =>{
                let accumulatorValue = res.data;
                this.setState({
                    value: accumulatorValue.value
                });
            });
        }        
    }
    saveOrUpdateAccumulatorValue = (e) => {
        e.preventDefault();
        let accumulatorValue = {
                accumulatorValueId: this.state.id,
                value: this.state.value
            };
        console.log('accumulatorValue => ' + JSON.stringify(accumulatorValue));

        // step 5
        if(this.state.id === '_add'){
            accumulatorValue.accumulatorValueId=''
            AccumulatorValueService.createAccumulatorValue(accumulatorValue).then(res =>{
                this.props.history.push('/accumulatorValues');
            });
        }else{
            AccumulatorValueService.updateAccumulatorValue(accumulatorValue).then( res => {
                this.props.history.push('/accumulatorValues');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/accumulatorValues');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AccumulatorValue</h3>
        }else{
            return <h3 className="text-center">Update AccumulatorValue</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAccumulatorValue}>Save</button>
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

export default CreateAccumulatorValueComponent
