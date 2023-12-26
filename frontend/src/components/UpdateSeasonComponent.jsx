import React, { Component } from 'react'
import SeasonService from '../services/SeasonService';

class UpdateSeasonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                endDate: '',
                startDate: ''
        }
        this.updateSeason = this.updateSeason.bind(this);

        this.changeendDateHandler = this.changeendDateHandler.bind(this);
        this.changestartDateHandler = this.changestartDateHandler.bind(this);
    }

    componentDidMount(){
        SeasonService.getSeasonById(this.state.id).then( (res) =>{
            let season = res.data;
            this.setState({
                endDate: season.endDate,
                startDate: season.startDate
            });
        });
    }

    updateSeason = (e) => {
        e.preventDefault();
        let season = {
            seasonId: this.state.id,
            endDate: this.state.endDate,
            startDate: this.state.startDate
        };
        console.log('season => ' + JSON.stringify(season));
        console.log('id => ' + JSON.stringify(this.state.id));
        SeasonService.updateSeason(season).then( res => {
            this.props.history.push('/seasons');
        });
    }

    changeendDateHandler= (event) => {
        this.setState({endDate: event.target.value});
    }
    changestartDateHandler= (event) => {
        this.setState({startDate: event.target.value});
    }

    cancel(){
        this.props.history.push('/seasons');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Season</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> endDate: </label>
                                            #formFields( $attribute, 'update')
                                            <label> startDate: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSeason}>Save</button>
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

export default UpdateSeasonComponent
