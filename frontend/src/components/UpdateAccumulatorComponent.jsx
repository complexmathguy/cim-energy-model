import React, { Component } from 'react'
import AccumulatorService from '../services/AccumulatorService';

class UpdateAccumulatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAccumulator = this.updateAccumulator.bind(this);

    }

    componentDidMount(){
        AccumulatorService.getAccumulatorById(this.state.id).then( (res) =>{
            let accumulator = res.data;
            this.setState({
            });
        });
    }

    updateAccumulator = (e) => {
        e.preventDefault();
        let accumulator = {
            accumulatorId: this.state.id,
        };
        console.log('accumulator => ' + JSON.stringify(accumulator));
        console.log('id => ' + JSON.stringify(this.state.id));
        AccumulatorService.updateAccumulator(accumulator).then( res => {
            this.props.history.push('/accumulators');
        });
    }


    cancel(){
        this.props.history.push('/accumulators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Accumulator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAccumulator}>Save</button>
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

export default UpdateAccumulatorComponent
