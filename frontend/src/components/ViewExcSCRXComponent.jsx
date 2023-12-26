import React, { Component } from 'react'
import ExcSCRXService from '../services/ExcSCRXService'

class ViewExcSCRXComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excSCRX: {}
        }
    }

    componentDidMount(){
        ExcSCRXService.getExcSCRXById(this.state.id).then( res => {
            this.setState({excSCRX: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcSCRX Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> cswitch:&emsp; </label>
                            <div> { this.state.excSCRX.cswitch }</div>
                        </div>
                        <div className = "row">
                            <label> emax:&emsp; </label>
                            <div> { this.state.excSCRX.emax }</div>
                        </div>
                        <div className = "row">
                            <label> emin:&emsp; </label>
                            <div> { this.state.excSCRX.emin }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.excSCRX.k }</div>
                        </div>
                        <div className = "row">
                            <label> rcrfd:&emsp; </label>
                            <div> { this.state.excSCRX.rcrfd }</div>
                        </div>
                        <div className = "row">
                            <label> tatb:&emsp; </label>
                            <div> { this.state.excSCRX.tatb }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excSCRX.tb }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excSCRX.te }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcSCRXComponent
