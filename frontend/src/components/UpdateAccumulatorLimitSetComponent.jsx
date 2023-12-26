import React, { Component } from 'react'
import AccumulatorLimitSetService from '../services/AccumulatorLimitSetService';

class UpdateAccumulatorLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAccumulatorLimitSet = this.updateAccumulatorLimitSet.bind(this);

    }

    componentDidMount(){
        AccumulatorLimitSetService.getAccumulatorLimitSetById(this.state.id).then( (res) =>{
            let accumulatorLimitSet = res.data;
            this.setState({
            });
        });
    }

    updateAccumulatorLimitSet = (e) => {
        e.preventDefault();
        let accumulatorLimitSet = {
            accumulatorLimitSetId: this.state.id,
        };
        console.log('accumulatorLimitSet => ' + JSON.stringify(accumulatorLimitSet));
        console.log('id => ' + JSON.stringify(this.state.id));
        AccumulatorLimitSetService.updateAccumulatorLimitSet(accumulatorLimitSet).then( res => {
            this.props.history.push('/accumulatorLimitSets');
        });
    }


    cancel(){
        this.props.history.push('/accumulatorLimitSets');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AccumulatorLimitSet</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAccumulatorLimitSet}>Save</button>
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

export default UpdateAccumulatorLimitSetComponent
