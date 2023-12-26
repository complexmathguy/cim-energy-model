import React, { Component } from 'react'
import SvTapStepService from '../services/SvTapStepService'

class ViewSvTapStepComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            svTapStep: {}
        }
    }

    componentDidMount(){
        SvTapStepService.getSvTapStepById(this.state.id).then( res => {
            this.setState({svTapStep: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SvTapStep Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> position:&emsp; </label>
                            <div> { this.state.svTapStep.position }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSvTapStepComponent
