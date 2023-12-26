import React, { Component } from 'react'
import AccumulatorResetService from '../services/AccumulatorResetService';

class UpdateAccumulatorResetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAccumulatorReset = this.updateAccumulatorReset.bind(this);

    }

    componentDidMount(){
        AccumulatorResetService.getAccumulatorResetById(this.state.id).then( (res) =>{
            let accumulatorReset = res.data;
            this.setState({
            });
        });
    }

    updateAccumulatorReset = (e) => {
        e.preventDefault();
        let accumulatorReset = {
            accumulatorResetId: this.state.id,
        };
        console.log('accumulatorReset => ' + JSON.stringify(accumulatorReset));
        console.log('id => ' + JSON.stringify(this.state.id));
        AccumulatorResetService.updateAccumulatorReset(accumulatorReset).then( res => {
            this.props.history.push('/accumulatorResets');
        });
    }


    cancel(){
        this.props.history.push('/accumulatorResets');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AccumulatorReset</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAccumulatorReset}>Save</button>
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

export default UpdateAccumulatorResetComponent
