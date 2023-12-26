import React, { Component } from 'react'
import AccumulatorService from '../services/AccumulatorService';

class CreateAccumulatorComponent extends Component {
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
            AccumulatorService.getAccumulatorById(this.state.id).then( (res) =>{
                let accumulator = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAccumulator = (e) => {
        e.preventDefault();
        let accumulator = {
                accumulatorId: this.state.id,
            };
        console.log('accumulator => ' + JSON.stringify(accumulator));

        // step 5
        if(this.state.id === '_add'){
            accumulator.accumulatorId=''
            AccumulatorService.createAccumulator(accumulator).then(res =>{
                this.props.history.push('/accumulators');
            });
        }else{
            AccumulatorService.updateAccumulator(accumulator).then( res => {
                this.props.history.push('/accumulators');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/accumulators');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Accumulator</h3>
        }else{
            return <h3 className="text-center">Update Accumulator</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAccumulator}>Save</button>
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

export default CreateAccumulatorComponent
