import React, { Component } from 'react'
import DCBaseTerminalService from '../services/DCBaseTerminalService';

class CreateDCBaseTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DCBaseTerminalService.getDCBaseTerminalById(this.state.id).then( (res) =>{
                let dCBaseTerminal = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCBaseTerminal = (e) => {
        e.preventDefault();
        let dCBaseTerminal = {
                dCBaseTerminalId: this.state.id,
            };
        console.log('dCBaseTerminal => ' + JSON.stringify(dCBaseTerminal));

        // step 5
        if(this.state.id === '_add'){
            dCBaseTerminal.dCBaseTerminalId=''
            DCBaseTerminalService.createDCBaseTerminal(dCBaseTerminal).then(res =>{
                this.props.history.push('/dCBaseTerminals');
            });
        }else{
            DCBaseTerminalService.updateDCBaseTerminal(dCBaseTerminal).then( res => {
                this.props.history.push('/dCBaseTerminals');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCBaseTerminals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCBaseTerminal</h3>
        }else{
            return <h3 className="text-center">Update DCBaseTerminal</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCBaseTerminal}>Save</button>
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

export default CreateDCBaseTerminalComponent
