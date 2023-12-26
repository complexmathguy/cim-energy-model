import React, { Component } from 'react'
import AccumulatorLimitSetService from '../services/AccumulatorLimitSetService';

class CreateAccumulatorLimitSetComponent extends Component {
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
            AccumulatorLimitSetService.getAccumulatorLimitSetById(this.state.id).then( (res) =>{
                let accumulatorLimitSet = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAccumulatorLimitSet = (e) => {
        e.preventDefault();
        let accumulatorLimitSet = {
                accumulatorLimitSetId: this.state.id,
            };
        console.log('accumulatorLimitSet => ' + JSON.stringify(accumulatorLimitSet));

        // step 5
        if(this.state.id === '_add'){
            accumulatorLimitSet.accumulatorLimitSetId=''
            AccumulatorLimitSetService.createAccumulatorLimitSet(accumulatorLimitSet).then(res =>{
                this.props.history.push('/accumulatorLimitSets');
            });
        }else{
            AccumulatorLimitSetService.updateAccumulatorLimitSet(accumulatorLimitSet).then( res => {
                this.props.history.push('/accumulatorLimitSets');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/accumulatorLimitSets');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AccumulatorLimitSet</h3>
        }else{
            return <h3 className="text-center">Update AccumulatorLimitSet</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAccumulatorLimitSet}>Save</button>
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

export default CreateAccumulatorLimitSetComponent
