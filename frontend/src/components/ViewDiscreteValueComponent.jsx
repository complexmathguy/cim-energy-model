import React, { Component } from 'react'
import DiscreteValueService from '../services/DiscreteValueService'

class ViewDiscreteValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            discreteValue: {}
        }
    }

    componentDidMount(){
        DiscreteValueService.getDiscreteValueById(this.state.id).then( res => {
            this.setState({discreteValue: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiscreteValue Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.discreteValue.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiscreteValueComponent
