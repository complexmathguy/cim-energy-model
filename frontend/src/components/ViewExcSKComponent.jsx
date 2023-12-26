import React, { Component } from 'react'
import ExcSKService from '../services/ExcSKService'

class ViewExcSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excSK: {}
        }
    }

    componentDidMount(){
        ExcSKService.getExcSKById(this.state.id).then( res => {
            this.setState({excSK: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcSK Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efdmax:&emsp; </label>
                            <div> { this.state.excSK.efdmax }</div>
                        </div>
                        <div className = "row">
                            <label> efdmin:&emsp; </label>
                            <div> { this.state.excSK.efdmin }</div>
                        </div>
                        <div className = "row">
                            <label> emax:&emsp; </label>
                            <div> { this.state.excSK.emax }</div>
                        </div>
                        <div className = "row">
                            <label> emin:&emsp; </label>
                            <div> { this.state.excSK.emin }</div>
                        </div>
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.excSK.k }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.excSK.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.excSK.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excSK.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kce:&emsp; </label>
                            <div> { this.state.excSK.kce }</div>
                        </div>
                        <div className = "row">
                            <label> kd:&emsp; </label>
                            <div> { this.state.excSK.kd }</div>
                        </div>
                        <div className = "row">
                            <label> kgob:&emsp; </label>
                            <div> { this.state.excSK.kgob }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excSK.kp }</div>
                        </div>
                        <div className = "row">
                            <label> kqi:&emsp; </label>
                            <div> { this.state.excSK.kqi }</div>
                        </div>
                        <div className = "row">
                            <label> kqob:&emsp; </label>
                            <div> { this.state.excSK.kqob }</div>
                        </div>
                        <div className = "row">
                            <label> kqp:&emsp; </label>
                            <div> { this.state.excSK.kqp }</div>
                        </div>
                        <div className = "row">
                            <label> nq:&emsp; </label>
                            <div> { this.state.excSK.nq }</div>
                        </div>
                        <div className = "row">
                            <label> qconoff:&emsp; </label>
                            <div> { this.state.excSK.qconoff }</div>
                        </div>
                        <div className = "row">
                            <label> qz:&emsp; </label>
                            <div> { this.state.excSK.qz }</div>
                        </div>
                        <div className = "row">
                            <label> remote:&emsp; </label>
                            <div> { this.state.excSK.remote }</div>
                        </div>
                        <div className = "row">
                            <label> sbase:&emsp; </label>
                            <div> { this.state.excSK.sbase }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excSK.tc }</div>
                        </div>
                        <div className = "row">
                            <label> te:&emsp; </label>
                            <div> { this.state.excSK.te }</div>
                        </div>
                        <div className = "row">
                            <label> ti:&emsp; </label>
                            <div> { this.state.excSK.ti }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.excSK.tp }</div>
                        </div>
                        <div className = "row">
                            <label> tr:&emsp; </label>
                            <div> { this.state.excSK.tr }</div>
                        </div>
                        <div className = "row">
                            <label> uimax:&emsp; </label>
                            <div> { this.state.excSK.uimax }</div>
                        </div>
                        <div className = "row">
                            <label> uimin:&emsp; </label>
                            <div> { this.state.excSK.uimin }</div>
                        </div>
                        <div className = "row">
                            <label> urmax:&emsp; </label>
                            <div> { this.state.excSK.urmax }</div>
                        </div>
                        <div className = "row">
                            <label> urmin:&emsp; </label>
                            <div> { this.state.excSK.urmin }</div>
                        </div>
                        <div className = "row">
                            <label> vtmax:&emsp; </label>
                            <div> { this.state.excSK.vtmax }</div>
                        </div>
                        <div className = "row">
                            <label> vtmin:&emsp; </label>
                            <div> { this.state.excSK.vtmin }</div>
                        </div>
                        <div className = "row">
                            <label> yp:&emsp; </label>
                            <div> { this.state.excSK.yp }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcSKComponent
