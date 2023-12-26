import React, { Component } from 'react'
import AccumulatorResetService from '../services/AccumulatorResetService';

class CreateAccumulatorResetComponent extends Component {
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
            AccumulatorResetService.getAccumulatorResetById(this.state.id).then( (res) =>{
                let accumulatorReset = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAccumulatorReset = (e) => {
        e.preventDefault();
        let accumulatorReset = {
                accumulatorResetId: this.state.id,
            };
        console.log('accumulatorReset => ' + JSON.stringify(accumulatorReset));

        // step 5
        if(this.state.id === '_add'){
            accumulatorReset.accumulatorResetId=''
            AccumulatorResetService.createAccumulatorReset(accumulatorReset).then(res =>{
                this.props.history.push('/accumulatorResets');
            });
        }else{
            AccumulatorResetService.updateAccumulatorReset(accumulatorReset).then( res => {
                this.props.history.push('/accumulatorResets');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/accumulatorResets');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AccumulatorReset</h3>
        }else{
            return <h3 className="text-center">Update AccumulatorReset</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAccumulatorReset}>Save</button>
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

export default CreateAccumulatorResetComponent
