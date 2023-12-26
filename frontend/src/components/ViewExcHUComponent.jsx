import React, { Component } from 'react'
import ExcHUService from '../services/ExcHUService'

class ViewExcHUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excHU: {}
        }
    }

    componentDidMount(){
        ExcHUService.getExcHUById(this.state.id).then( res => {
            this.setState({excHU: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcHU Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ae:&emsp; </label>
                            <div> { this.state.excHU.ae }</div>
                        </div>
                        <div className = "row">
                            <label> ai:&emsp; </label>
                            <div> { this.state.excHU.ai }</div>
                        </div>
                        <div className = "row">
                            <label> atr:&emsp; </label>
                            <div> { this.state.excHU.atr }</div>
                        </div>
                        <div className = "row">
                            <label> emax:&emsp; </label>
                            <div> { this.state.excHU.emax }</div>
                        </div>
                        <div className = "row">
                            <label> emin:&emsp; </label>
                            <div> { this.state.excHU.emin }</div>
                        </div>
                        <div className = "row">
                            <label> imax:&emsp; </label>
                            <div> { this.state.excHU.imax }</div>
                        </div>
                        <div className = "row">
                            <label> imin:&emsp; </label>
                            <div> { this.state.excHU.imin }</div>
                        </div>
                        <div className = "row">
                            <label> ke:&emsp; </label>
                            <div> { this.state.excHU.ke }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.excHU.ki }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excHU.te }</div>
                        </div>
                        <div className = "row">
                            <label> ti:&emsp; </label>
                            <div> { this.state.excHU.ti }</div>
                        </div>
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.excHU.tr }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcHUComponent
