import React, { Component } from 'react'
import WindContCurrLimIECService from '../services/WindContCurrLimIECService'

class ViewWindContCurrLimIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContCurrLimIEC: {}
        }
    }

    componentDidMount(){
        WindContCurrLimIECService.getWindContCurrLimIECById(this.state.id).then( res => {
            this.setState({windContCurrLimIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContCurrLimIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> imax:&emsp; </label>
                            <div> { this.state.windContCurrLimIEC.imax }</div>
                        </div>
                        <div className = "row">
                            <label> imaxdip:&emsp; </label>
                            <div> { this.state.windContCurrLimIEC.imaxdip }</div>
                        </div>
                        <div className = "row">
                            <label> mdfslim:&emsp; </label>
                            <div> { this.state.windContCurrLimIEC.mdfslim }</div>
                        </div>
                        <div className = "row">
                            <label> mqpri:&emsp; </label>
                            <div> { this.state.windContCurrLimIEC.mqpri }</div>
                        </div>
                        <div className = "row">
                            <label> tufilt:&emsp; </label>
                            <div> { this.state.windContCurrLimIEC.tufilt }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContCurrLimIECComponent
