import React, { Component } from 'react'
import RegulatingCondEqService from '../services/RegulatingCondEqService';

class UpdateRegulatingCondEqComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateRegulatingCondEq = this.updateRegulatingCondEq.bind(this);

    }

    componentDidMount(){
        RegulatingCondEqService.getRegulatingCondEqById(this.state.id).then( (res) =>{
            let regulatingCondEq = res.data;
            this.setState({
            });
        });
    }

    updateRegulatingCondEq = (e) => {
        e.preventDefault();
        let regulatingCondEq = {
            regulatingCondEqId: this.state.id,
        };
        console.log('regulatingCondEq => ' + JSON.stringify(regulatingCondEq));
        console.log('id => ' + JSON.stringify(this.state.id));
        RegulatingCondEqService.updateRegulatingCondEq(regulatingCondEq).then( res => {
            this.props.history.push('/regulatingCondEqs');
        });
    }


    cancel(){
        this.props.history.push('/regulatingCondEqs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RegulatingCondEq</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRegulatingCondEq}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateRegulatingCondEqComponent
