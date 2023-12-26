import React, { Component } from 'react'
import ExcSEXSService from '../services/ExcSEXSService'

class ViewExcSEXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excSEXS: {}
        }
    }

    componentDidMount(){
        ExcSEXSService.getExcSEXSById(this.state.id).then( res => {
            this.setState({excSEXS: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcSEXS Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdmax:&emsp; </label>
                            <div> { this.state.excSEXS.efdmax }</div>
                        </div>
                        <div className = "row">
                            <label> efdmin:&emsp; </label>
                            <div> { this.state.excSEXS.efdmin }</div>
                        </div>
                        <div className = "row">
                            <label> emax:&emsp; </label>
                            <div> { this.state.excSEXS.emax }</div>
                        </div>
                        <div className = "row">
                            <label> emin:&emsp; </label>
                            <div> { this.state.excSEXS.emin }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.excSEXS.k }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excSEXS.kc }</div>
                        </div>
                        <div className = "row">
                            <label> tatb:&emsp; </label>
                            <div> { this.state.excSEXS.tatb }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excSEXS.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excSEXS.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excSEXS.te }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcSEXSComponent
