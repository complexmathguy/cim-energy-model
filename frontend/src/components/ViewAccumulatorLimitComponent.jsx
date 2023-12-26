import React, { Component } from 'react'
import AccumulatorLimitService from '../services/AccumulatorLimitService'

class ViewAccumulatorLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            accumulatorLimit: {}
        }
    }

    componentDidMount(){
        AccumulatorLimitService.getAccumulatorLimitById(this.state.id).then( res => {
            this.setState({accumulatorLimit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AccumulatorLimit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.accumulatorLimit.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAccumulatorLimitComponent
