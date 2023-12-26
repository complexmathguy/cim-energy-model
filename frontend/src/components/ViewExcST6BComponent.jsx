import React, { Component } from 'react'
import ExcST6BService from '../services/ExcST6BService'

class ViewExcST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST6B: {}
        }
    }

    componentDidMount(){
        ExcST6BService.getExcST6BById(this.state.id).then( res => {
            this.setState({excST6B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST6B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ilr:&emsp; </label>
                            <div> { this.state.excST6B.ilr }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.excST6B.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> kcl:&emsp; </label>
                            <div> { this.state.excST6B.kcl }</div>
                        </div>
                        <div className = "row">
                            <label> kff:&emsp; </label>
                            <div> { this.state.excST6B.kff }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.excST6B.kg }</div>
                        </div>
                        <div className = "row">
                            <label> kia:&emsp; </label>
                            <div> { this.state.excST6B.kia }</div>
                        </div>
                        <div className = "row">
                            <label> klr:&emsp; </label>
                            <div> { this.state.excST6B.klr }</div>
                        </div>
                        <div className = "row">
                            <label> km:&emsp; </label>
                            <div> { this.state.excST6B.km }</div>
                        </div>
                        <div className = "row">
                            <label> kpa:&emsp; </label>
                            <div> { this.state.excST6B.kpa }</div>
                        </div>
                        <div className = "row">
                            <label> kvd:&emsp; </label>
                            <div> { this.state.excST6B.kvd }</div>
                        </div>
                        <div className = "row">
                            <label> oelin:&emsp; </label>
                            <div> { this.state.excST6B.oelin }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.excST6B.tg }</div>
                        </div>
                        <div className = "row">
                            <label> ts:&emsp; </label>
                            <div> { this.state.excST6B.ts }</div>
                        </div>
                        <div className = "row">
                            <label> tvd:&emsp; </label>
                            <div> { this.state.excST6B.tvd }</div>
                        </div>
                        <div className = "row">
                            <label> vamax:&emsp; </label>
                            <div> { this.state.excST6B.vamax }</div>
                        </div>
                        <div className = "row">
                            <label> vamin:&emsp; </label>
                            <div> { this.state.excST6B.vamin }</div>
                        </div>
                        <div className = "row">
                            <label> vilim:&emsp; </label>
                            <div> { this.state.excST6B.vilim }</div>
                        </div>
                        <div className = "row">
                            <label> vimax:&emsp; </label>
                            <div> { this.state.excST6B.vimax }</div>
                        </div>
                        <div className = "row">
                            <label> vimin:&emsp; </label>
                            <div> { this.state.excST6B.vimin }</div>
                        </div>
                        <div className = "row">
                            <label> vmult:&emsp; </label>
                            <div> { this.state.excST6B.vmult }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excST6B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excST6B.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> xc:&emsp; </label>
                            <div> { this.state.excST6B.xc }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST6BComponent
