import React, { Component } from 'react'
import AccumulatorValueService from '../services/AccumulatorValueService'

class ViewAccumulatorValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            accumulatorValue: {}
        }
    }

    componentDidMount(){
        AccumulatorValueService.getAccumulatorValueById(this.state.id).then( res => {
            this.setState({accumulatorValue: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AccumulatorValue Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.accumulatorValue.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAccumulatorValueComponent
