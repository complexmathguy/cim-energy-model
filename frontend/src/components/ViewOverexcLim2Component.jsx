import React, { Component } from 'react'
import OverexcLim2Service from '../services/OverexcLim2Service'

class ViewOverexcLim2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcLim2: {}
        }
    }

    componentDidMount(){
        OverexcLim2Service.getOverexcLim2ById(this.state.id).then( res => {
            this.setState({overexcLim2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcLim2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ifdlim:&emsp; </label>
                            <div> { this.state.overexcLim2.ifdlim }</div>
                        </div>
                        <div className = "row">
                            <label> koi:&emsp; </label>
                            <div> { this.state.overexcLim2.koi }</div>
                        </div>
                        <div className = "row">
                            <label> voimax:&emsp; </label>
                            <div> { this.state.overexcLim2.voimax }</div>
                        </div>
                        <div className = "row">
                            <label> voimin:&emsp; </label>
                            <div> { this.state.overexcLim2.voimin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcLim2Component
