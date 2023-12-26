import React, { Component } from 'react'
import TerminalService from '../services/TerminalService';

class UpdateTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTerminal = this.updateTerminal.bind(this);

    }

    componentDidMount(){
        TerminalService.getTerminalById(this.state.id).then( (res) =>{
            let terminal = res.data;
            this.setState({
            });
        });
    }

    updateTerminal = (e) => {
        e.preventDefault();
        let terminal = {
            terminalId: this.state.id,
        };
        console.log('terminal => ' + JSON.stringify(terminal));
        console.log('id => ' + JSON.stringify(this.state.id));
        TerminalService.updateTerminal(terminal).then( res => {
            this.props.history.push('/terminals');
        });
    }


    cancel(){
        this.props.history.push('/terminals');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Terminal</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTerminal}>Save</button>
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

export default UpdateTerminalComponent
