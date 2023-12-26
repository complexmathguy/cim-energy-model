import React, { Component } from 'react'
import AccumulatorResetService from '../services/AccumulatorResetService'

class ViewAccumulatorResetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            accumulatorReset: {}
        }
    }

    componentDidMount(){
        AccumulatorResetService.getAccumulatorResetById(this.state.id).then( res => {
            this.setState({accumulatorReset: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AccumulatorReset Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAccumulatorResetComponent
