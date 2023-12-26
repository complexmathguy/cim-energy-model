import React, { Component } from 'react'
import DCBaseTerminalService from '../services/DCBaseTerminalService';

class UpdateDCBaseTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCBaseTerminal = this.updateDCBaseTerminal.bind(this);

    }

    componentDidMount(){
        DCBaseTerminalService.getDCBaseTerminalById(this.state.id).then( (res) =>{
            let dCBaseTerminal = res.data;
            this.setState({
            });
        });
    }

    updateDCBaseTerminal = (e) => {
        e.preventDefault();
        let dCBaseTerminal = {
            dCBaseTerminalId: this.state.id,
        };
        console.log('dCBaseTerminal => ' + JSON.stringify(dCBaseTerminal));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCBaseTerminalService.updateDCBaseTerminal(dCBaseTerminal).then( res => {
            this.props.history.push('/dCBaseTerminals');
        });
    }


    cancel(){
        this.props.history.push('/dCBaseTerminals');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCBaseTerminal</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCBaseTerminal}>Save</button>
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

export default UpdateDCBaseTerminalComponent
