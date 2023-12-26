import React, { Component } from 'react'
import AccumulatorService from '../services/AccumulatorService'

class ViewAccumulatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            accumulator: {}
        }
    }

    componentDidMount(){
        AccumulatorService.getAccumulatorById(this.state.id).then( res => {
            this.setState({accumulator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Accumulator Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAccumulatorComponent
